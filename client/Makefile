# aliases

## src files

MAIN_LESS = styles/main.less
MAIN_JS   = scripts/main.js

## dist files

R         = ../server/src/main/resources
DIST_TMPL = $(R)/templates
DIST_CSS  = $(R)/static/bundle.css
DIST_JS   = $(R)/static/bundle.js
DIST_FONT = $(R)/static/fonts

# targets

## main targets

.PHONY: all watch

all: clean $(DIST_TMPL) $(DIST_JS) $(DIST_CSS) $(DIST_FONT)

watch:
	@$(MAKE) $(DIST_TMPL) $(DIST_CSS) $(DIST_FONT)
	@$(MAKE) -j watch-tmpl watch-less watch-js

## sub targets

.PHONY: $(DIST_TMPL) $(DIST_JS) $(DIST_CSS) $(DIST_FONT) watch-js watch-tmpl watch-less build-js clean

$(DIST_TMPL): node_modules
	@rsync -a templates/ $@

$(DIST_JS): node_modules $(R)/static
	@node_modules/.bin/browserify $(MAIN_JS) \
		-o $@

$(DIST_CSS): node_modules $(R)/static
	@node_modules/.bin/lessc $(MAIN_LESS) $@

$(DIST_FONT): node_modules $(R)/static
	@mkdir -p $@
	@rsync -a node_modules/font-awesome/{css,fonts} $@

watch-tmpl: node_modules $(DIST_TMPL)
	@node_modules/.bin/watchf 'templates/**/*.html' -c 'rsync -aR {} $(R)'

watch-js: node_modules $(R)/static
	@node_modules/.bin/watchify $(MAIN_JS) \
		-d \
		-v \
		-o $(DIST_JS)

watch-less: node_modules $(R)/static
	@node_modules/.bin/watchf styles/**/*.less -c 'make $(DIST_CSS)'

$(R)/static:
	@mkdir -p $@

clean:
	@rm -rf $(DIST_TMPL) $(DIST_JS) $(DIST_CSS) $(DIST_FONT)

node_modules: package.json
	@npm install
