# aliases

## src files

LESSES    = styles/**/*.less
MAIN_LESS = styles/main.less
MAIN_JS   = scripts/main.js

## dist files

R         = ../server/src/main/resources
TMPL_DIR  = $(R)/templates
DIST_CSS  = $(R)/static/bundle.css
DIST_JS   = $(R)/static/bundle.js

# targets

## main targets

.PHONY: all watch

all: clean $(DIST_JS) $(DIST_CSS)

watch:
	@$(MAKE) -j 2 watch-less watch-js

## sub targets

.PHONY: watch-js watch-less build-js clean

$(DIST_JS): node_modules
	@node_modules/.bin/browserify $(MAIN_JS) \
		-t [ babelify --presets es2015 ] \
		-o $(DIST_JS)

$(DIST_CSS): node_modules
	@node_modules/.bin/lessc $(MAIN_LESS) $(DIST_CSS)

watch-js: node_modules
	@node_modules/.bin/watchify $(MAIN_JS) \
		-d \
		-v \
		-t [ babelify --presets es2015 ] \
		-o $(DIST_JS)

watch-less:
	@$(MAKE) $(DIST_CSS)
	@node_modules/.bin/watchf $(LESSES) -c 'make $(DIST_CSS)'

clean:
	rm -rf $(DIST_JS) $(DIST_CSS)

node_modules: package.json
	@npm install
