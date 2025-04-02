Elijah cegont-upper (prolific-remnant)
=======================================

The elijah-lang compiler/package manager.

`prolific-remnant` is derived from problem-set-1004 with minimal extras, this repo notwithstanding.

## RATIONALE

*tldr*: half-ass cegont-upper in the purpose of gh ci

`cegont-upper` is a half-ass attempt at compiling less in an unpublished multi-project
pom where we put the things that don't change much.

The vendoring is wrong, I think - proguard is our friend here.

Also something bothers me about range and buffers.

With less diatribe, most everything here needs to change.


## Notes

- Restored generic to Buffer.../Transform

- Using internal NIE

- Including commons-lang3 here like it is is "less than optimal".


## LICENSES

We are (quasi illegally) vendoring: 

* commons-lang3 (Apache)
* antlr (prob public domain)
* jdeferred2 (prob LGPL2, maybe with classpath exception)


## BLATHER

Elijah is:

- ... not actually related to snakes.
- ... an interesting time-sink.
- ... free software (LGPL) intended for use on all systems, even Windows.


## TODO

1. Add commons-codec?

2. Gradle adds some nice thing to publishing, fwiw.
