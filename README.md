Elijah cegont-upper (prolific-remnant)
=======================================

The elijah-lang compiler/package manager.

`prolific-remnant` is derived from problem-set-1004 with minimal extras.

> So stop changing package names (-- Java (aka the 90s) makes this difficult "in ways".  OSGi (aka the naughties) possibly fixes it.)

## RATIONALE

*tldr*: half-ass cegont-upper in the purpose of gh ci

`cegont-upper` is an as of yet incomplete attempt at compiling less in an (maybe maybe not) unpublished
multi-project pom in order to house classfiles that do not change much, hopefully saving processor cycles
in javac/kotlinc (but prob. compounding them with tcp, ugh)

> unpublished: using it now all over the place.  The other one is, yeah, unpublished and not really important.

Also something bothers me about range and buffers.

- My psych. told me to stop talking about the politics of online communities, etc.

- Can't/won't figure out tries/finger trees/electric (not actually related)/automerge (rust in general).

- kit/buffers/nextgen-os + lmt = boom!


There will be turnover.  Just not that much.


## Notes

- Restored generic to Buffer.../Transform

- Using internal NIE


## LICENSES

Ignoring the details on:

* commons-lang3 (Apache)
* antlr (prob public domain)
* jdeferred2 (prob LGPL2, maybe with classpath exception)


## BLATHER

Elijah is:

- ... heavily influenced by snakes (in an earlier incarnation).
- ... an interesting time-sink.
- ... seemingly everything but a compiler, transpiler or not.
- ... free software (LGPL) intended for use on all systems, even Windows.


## TODO

1. Add commons-codec?

2. Gradle adds some nice things to publishing, fwiw. (cf gl)

2b. `develocity` is for enterprise.  Elijah is just a rocket.

3. I'm not convinced that nix+ant is not better.  Clearly, you haven't heard of bazel?

4. Honestly, I wish NetBeans and me could get along better. (I think I said that right.)

5. Use shade/proguard on commons-lang3, and while you're at it, guava and could be jdt and jena (like elevated- and congenial-upper).

6. This has nothing to do with this project: bloop/lsp.

7. .sdkmanrc is not working on /.../cb6a2sby001lyrinvmm5g82ljm1vvvvx-idea-community
