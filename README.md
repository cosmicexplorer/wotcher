wotcher
=======

# notes
## sources
- file paths
- file content
    - text
        - *encodings?*
        - *filetypes?*
            - e.g. json, xml, html
                - e.g. allow for searching json file content using jq filters (?)
    - binary
        - *filetypes?*
- symbols
    - types/classes
    - methods/fields
    - local/global vars
        - *which scopes?*

## search parameters
- a conjunction of predicates from any selection of the above sources
    - and/or/not/etc
- *modifiers* in the same vein as regex special characters
    - e.g. "fuzzy match" (with tweakable amount of leeway), "match whole string", etc
        - consider existing modifiers, such as those usable for emacs's `isearch` (e.g. `case-fold-search`, `char-fold-search`, etc)

## performance
- store previous results in structured, searchable format
    - *exists free local db for e.g. "find" results?*
- *seed* results of next search with matching results of previous
    - e.g. if we just searched `Build` in file content in some directory, and then search `Builder` in file content in the same directory, the results from the second search are a strict subset of the previous
- asynchronously update db with watchman/etc
    - don't spend the user's cpu cycles in background for no reason!!
    - use watchman for "hot" search areas where it reduces the need to manually traverse filesystem or search files
        - *need to be able to transparently use these "passive" results as if they were the same as doing an uncached search, and ensure the results stay up to date!*
- **only care about perf where necessary**

## cli
- maybe some sort of curses thing in the future
- for now, use it like grep/ag/etc
- pattern format should be able to handle different [sources](#sources) and [conjunctions of search parameters](#search-parameters)
    - do we interpret a string at all? do we do something different? what?

# the name is dumb
It's called `wotcher` because it watches for changes in search results, and because its primary use case is interactive search (in which case, "wotcher" would be a salutation to the user).

## no like the package name
yeah don't depend on this code

# license
[GPL 3.0+](./LICENSE)
