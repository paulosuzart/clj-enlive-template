# clj-enlive-template

A Leiningen template for projects using [Webnoir](http://www.webnoir.org/) plus  [enlive](https://github.com/cgrand/enlive). 

Enlive lets you work with `css` selectors agains your views, what IMO is a big advantage. It allows for working with pure html instead of hiccup - a great framework - vectors.

It comes with sample snippets as well as a main template to help you setup you own.

In future versions it will offer more common functions and view helper functions. Maybe korma or other persistence mecanishm.

## Usage

Don't forget to use either [lein2](http://leiningen.org/) or [lein-newnew](https://github.com/Raynes/lein-newnew). And then:

    lein plugin install clj-enlive-template 0.0.1
    lein new clj-enlive-template myproj
    cd myproj
    lein run

Done!

See the instructions in `myproj/README.md`

## Caveats for enlive

You may notice in the sample `_login` snippet that it takes as argument, the error list coming from `webnoir.validation/get-errors` instead of accessing it directly. Noir dynamic are not bound during the processing of the snippet.

The same happens with cookies.


## License

Copyright © 2012 [Paulo Suzart](http://paulosuzart.github.com/) ([@paulosuzart](http://twitter.com/paulosuzart)). 

Distributed under the Eclipse Public License, the same as Clojure.

