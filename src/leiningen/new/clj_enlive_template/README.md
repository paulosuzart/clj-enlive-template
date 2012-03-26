# {{name}}

A simple project for creating web apps using [Webnoir](http://www.webnoir.org/) plus  [enlive](https://github.com/cgrand/enlive).

## Usage

```bash
lein deps
lein run
```


## Some tips (remove this section)

Then browse to `http://localhost:8090/login`. This page does nothing. It just has tow fileds backaed by a enlive snippet and `noir.validation`.'

As a convention, I would recommend you to keep the following structure to your projetc:

    |-{{name}}
    |---views
    |-----layout # put main templates here
    |-------main.html
    |-----_login.html # put an _ in front of snippet files
    |-----commont.clj # common view functions
    |-----login.clj # defpages to handle /login/*
    |-----foo # defpages to handle /foo/*


## License

Copyright (C) 2012 FIXME

Distributed under the Eclipse Public License, the same as Clojure.


