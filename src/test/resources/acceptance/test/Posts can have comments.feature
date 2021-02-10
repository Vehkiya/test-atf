@Comments
Feature: Posts can have comments

  Posts should support the functionality of comments
  Every comment contains the name and email of the commenter as well as the body of the comment

  @Positive
  Scenario: Comments can be posted
    Given a random 'post'
    When user adds a new comment
    Then the comment is 'visible' in associated post

  @Positive
  Scenario: Comments can be deleted
    Given a random 'post'
    When user deletes his comment
    Then the comment is 'not visible' in associated post

  @Negative
  Scenario Outline: Comments cannot be posted without mandatory fields
    Given a random 'post'
    When user adds a new comment with empty '<field>'
    Then user receives an error
    Examples:
      | field |
      | email |
      | name  |
      | body  |