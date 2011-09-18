% Executable Specifications 
% Arnaud Bailly 
% 13/09/2011

# Introduction

# Agile Testing Taxonomy: Marick' Quadrant

![](figures/marick-quadrants.jpg)

# TDD, BDD

- TDD: Core XP Practice, Unit testing, Test First development
- Is BDD ["TDD done right" ?](http://codebetter.com/jeremymiller/2007/09/06/bdd-tdd-and-the-other-double-d-s/)
- Technology facing tests that support the team

# Acceptance Tests, ATDD, Functional tests

- Also in original XP core practices
- Acceptance is an heavily overloaded term
- Business facing tests that support the team
- "Specification beyond the post-its"

# But...

- Testing applications end-to-end is *hard*
- Scripting UIs is *bad*, this has been done for ages (eg. WinRunner)
  and led to piling hordes of regression test suites that take ages to
  run and catch very few bugs (eg. see
  [this article](http://www.qanc.co.kr/4research_0402_download.htm?data_no=54&name=Brian%20Marick-How%20Many%20Bugs%20Do%20Regression%20Tests%20Find.pdf))
- Tests are brittle: *Very high maintenance costs*

# Enter "Specification By Example"

- ATDD Done Right ! :-)
- Advocated By Gojko Adzic and others from the Agile Testing community
- Also be called *Executable Specification*, but this is questionable
-- A *specification* is itself an encoding of the problem at hand is in nature *continuous*
-- We deal here only with examples, that is a *discrete* sampling of problem/solutions space

# We are not alone

> "Pour établir une pratique, les règles ne suffisent pas; on a également besoin d'exemples"

L.Wittgenstein, *De la certitude*, 1969


#  The Goals 

- Specification of stories beyond the post-it
- A story should be an opportunity to conversation, but how do we know we are done?
- But we want to build a product...

# Product vs. Project

- Stories represent the *path* we follow to develop the software: Each
  story modifies the *product* in some specific way
- But the *product* is not the sum of the stories: It is not possible
  to reconstruct the exact set of stories implemented given a specific
  state of the product (apart from using VCS, of course)
- Hence the question: Do we need to keep all those tests we write to
  implement stories? 
  
# Evolving Tests

- A possible workflow might be:
  1. Define acceptance tests for a given story before coding start,
  write them down as they come as executable acceptance tests
  2. Once story is done, transform tests into *specifications
  examples*: Move them to some relevant set of tests for the featur
  this story introduces/complete
  3. Use human tests to improve on 2., hence possibly creating new
  stories for 1., In particular, testers (and developers of course)
  are good at finding corner cases, uncovered paths, contradictions...

# Execution

# Conclusion


