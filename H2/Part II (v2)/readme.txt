# Efficiency Test for UnbalancedTreeMap and java.util.TreeMap


## Running Times
- Custom UnbalancedTreeMap Time: 0.1665 seconds
- Java's Standard TreeMap Time: 0.0995 seconds


## Comparison and Justification

The execution time of Java's standard `TreeMap` was faster than our custom `UnbalancedTreeMap` in the test scenario, taking 0.0995 seconds. Our custom map took about 0.1665 seconds. This difference is likely because of the various optimizations that are built into Java's library that make it run faster. 

Our custom `UnbalancedTreeMap` is unbalanced, meaning its performance degrades as the number of elements increases or if the data makes the tree unbalanced. This would lead to more time spent in locating and inserting nodes in the correct places, and the longer execution time reflects this.
