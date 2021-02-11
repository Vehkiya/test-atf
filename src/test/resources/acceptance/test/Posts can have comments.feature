@Comments
Feature: Posts can have comments

  Posts should support the functionality of comments
  Every comment contains the name and email of the commenter as well as the body of the comment

  @Smoke
  @Positive
  Scenario: Comments can be posted
    Given a random post
    When a new comment is added
    Then the comment is 'visible' in associated post

  @Positive
  Scenario: Comments can be deleted
    Given a random post
    When a comment is deleted
    Then the comment is 'not visible' in associated post