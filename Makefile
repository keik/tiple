# path
STATIC      = src/main/resources/static

# src files
LESSES      = $(STATIC)/less/*.less
MAIN_LESS   = $(STATIC)/less/main.less
MAIN_JS	  = $(STATIC)/script/main.es

# dist files
DIST_CSS         = $(STATIC)/main.css
DIST_JS	= $(STATIC)/bundle.js

watch:
	@make -j 2 watch-less watch-js

run-server:
	@mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=prod"

run-dev-server:
	@mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=dev"

watch-js: node_modules
	@node_modules/.bin/watchify $(MAIN_JS) \
		-d \
		-v \
		-t [ babelify --presets es2015 ] \
		-o $(DIST_JS)

watch-less:
	@node_modules/.bin/lessc $(MAIN_LESS) $(DIST_CSS)
	@node_modules/.bin/watchf $(LESSES) -c 'make $(DIST_CSS)'

target: clean
	@mvn package

$(MAIN_JS): node_modules
	@node_modules/.bin/browserify $(MAIN_JS) -t [ babelify --presets es2015 ] -o $(MAIN_JS)

$(DIST_CSS): node_modules $(LESSES)
	@node_modules/.bin/lessc $(MAIN_LESS) $(DIST_CSS)

clean: pom.xml
	@mvn clean

node_modules: package.json
	@npm install

.PHONY: watch run-dev-server watch-js watch-less build-java build-js build-less clean
