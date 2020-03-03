# RBTreeTransplant
Explanation:
  RB Tree transplant, means merging two RB tree.
  For transplant to take place, one of the RB tree is traversed in InOrder way and the data values of that RB tree will be stored in an array. 
  This array is again given as an input to the other RB tree. The insert function of the RB tree is called in a loop until all the element of are entered.

Input:
    1.	RB tree 1
    2.	RB tree 2
Output:
    1.	New RB tree with values of both RB tree1 and RB Tree2 (Duplicate values will be discarded )
Observation:
   If we consider the black height of RB Tree1 as H1 and Black height of RB Tree2 as H2
   Then,
      The BlackHeight of the resultant RB tree after merging will be MAX(H1,H2).
