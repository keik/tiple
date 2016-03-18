# aliases

## src files

MAIN_LESS = styles/main.less
MAIN_JS   = scripts/main.js

## dist files

R         = ../server/src/main/resources
DIST_TMPL = $(R)/templates
DIST_CSS  = $(R)/static/bundle.css
DIST_JS   = $(R)/static/bundle.js

# targets

## main targets

.PHONY: all watch

all: clean $(DIST_TMPL) $(DIST_JS) $(DIST_CSS)

watch:
	@$(MAKE) -j 3 watch-tmpl watch-less watch-js

## sub targets

.PHONY: watch-js watch-tmpl watch-less build-js clean

$(DIST_TMPL): node_modules
		@cp templates $(R)/templates -r

$(DIST_JS): node_modules $(R)/static
	@node_modules/.bin/browserify $(MAIN_JS) \
		-t [ babelify --presets es2015 ] \
		-o $@

$(DIST_CSS): node_modules $(R)/static
	@node_modules/.bin/lessc $(MAIN_LESS) $@

watch-tmpl: node_modules $(DIST_TMPL)
	@node_modules/.bin/watchf 'templates/**/*.html' -c 'cp --parents {} $(R)'

watch-js: node_modules $(R)/static
	@node_modules/.bin/watchify $(MAIN_JS) \
		-d \
		-v \
		-t [ babelify --presets es2015 ] \
		-o $(DIST_JS)

watch-less: node_modules $(R)/static
	@$(MAKE) $(DIST_CSS)
	@node_modules/.bin/watchf styles/**/*.less -c 'make $(DIST_CSS)'

$(R)/static:
	@mkdir -p $@

clean:
	@rm -rf $(DIST_TMPL) $(DIST_JS) $(DIST_CSS)

node_modules: package.json
	@npm install
