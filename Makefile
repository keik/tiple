# aliases

## none

# targets

## main targets

.PHONY: all watch run-server run-dev-server

all: clean server/target

watch:
	@$(MAKE) -C client watch

run-server:
	@mvn -f server/pom.xml spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=prod"

run-dev-server:
	@mvn -f server/pom.xml spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=dev"

## sub targets

.PHONY: clean

server/target:
	@$(MAKE) -C client all
	@mvn -f server/pom.xml package

clean:
	@mvn -f server/pom.xml clean
