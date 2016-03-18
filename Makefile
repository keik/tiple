# aliases

## src files

LESSES    = client/styles/**/*.less
MAIN_LESS = client/styles/main.less
MAIN_JS   = client/scripts/script/main.js

## dist files

R         = src/main/resources/
TMPL_DIR  = $(R)/templates
DIST_CSS  = $(R)/static/main.css
DIST_JS   = $(R)/staticbundle.js

# targets

## main targets

.PHONY: all watch run-server run-dev-server

all:
	@echo NOT CONFIGURED

watch:
	@make -j 2 watch-less watch-js

run-server:
	@mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=prod"

run-dev-server:
	@mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=dev"

## sub targets

.PHONY: watch-js watch-less build-js clean

target: clean
	@mvn package

$(MAIN_JS): node_modules
	@node_modules/.bin/browserify $(MAIN_JS) -t [ babelify --presets es2015 ] -o $(MAIN_JS)

$(DIST_CSS): node_modules $(LESSES)
	@node_modules/.bin/lessc $(MAIN_LESS) $(DIST_CSS)

clean: pom.xml
	@mvn clean
