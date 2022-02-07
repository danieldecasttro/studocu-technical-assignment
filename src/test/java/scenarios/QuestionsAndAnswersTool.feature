@Test
Feature: Q&A Tool
  User should be able to Create a question.
  User should be able to View the question created.
  User should be able to view the answer by clicking in the question
  User should be able to Remove questions

  Scenario: Create a Question and check if the question is listed
    Given the user is at the website "http://127.0.0.1:8000/"
    When the user creates the question "<question>" with the answer "<answer>"
    Then the user should be able to see the question "<question>" in the page
    Examples:
        |question|answer|
        |Question 1|Answer to Question 1|

  Scenario: Create a Question and check if the answer is present
      Given the user is at the website "http://127.0.0.1:8000/"
      When the user creates the question "<question>" with the answer "<answer>"
      Then the user should be able to see the question "<question>" in the page
      And the user should be able to expand and see the answer "<answer>" for the question "<question>"
      Examples:
          |question|answer|
          |Question 2|Answer to Question 2|

  Scenario: Remove questions and check if the questions have gone
        Given the user is at the website "http://127.0.0.1:8000/"
        When the user removes the questions
        Then no questions are listed