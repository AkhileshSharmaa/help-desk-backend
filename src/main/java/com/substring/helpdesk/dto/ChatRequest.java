package com.substring.helpdesk.dto;

import lombok.Data;

@Data
public class ChatRequest {
    private String message;
}


/*
[
        {
       [
  {
    "person": "Paul",
    "prompt": 1,
    "message": "Hey, my name is Paul. I am facing an issue with the website and I need help."
  },
  {
    "person": "Paul",
    "prompt": 2,
    "message": "The website is not loading properly and shows errors on multiple pages. This is high priority because I need it for work. My email is paul.anderson@substringtech.com."
  },
  {
    "person": "John",
    "prompt": 1,
    "message": "Hi, my name is John. I am having some trouble and I need assistance from support."
  },
  {
    "person": "John",
    "prompt": 2,
    "message": "I am unable to log in to my account even after resetting my password. This issue is blocking my work, so it is urgent. My email address is john.miller@substringtech.com."
  },
  {
    "person": "Sarah",
    "prompt": 1,
    "message": "Hello, my name is Sarah. I am facing an issue and would like help from the support team."
  },
  {
    "person": "Sarah",
    "prompt": 2,
    "message": "Whenever I try to upload my assignment, I get a server error. This is very urgent because the deadline is today. My email is sarah.williams@edu.com."
  }
]

*/

