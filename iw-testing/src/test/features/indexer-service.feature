Feature: Indexer Service
  In order to limit reindexation
  IndexerService will need to retrieve changed documents periodically
  
  Scenario: Retrieve Added Documents
    Given documents database contains:
    | Uri  | Created Time | Info Type |
    | doc1 |            0 | type1     |
    | doc2 |            0 | type2     |
    When getting changed since time 0 
    Then I retrieve 2 documents
    

    
