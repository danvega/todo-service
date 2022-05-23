# Consume API into Database & Push to Another Service

This is a question I got from a subscriber to my [newsletter](https://www.danvega.dev/newsletter/). I thought this was 
a great question and probably a scenario a lot of us are running into. I decided to answer this on 
[Spring Office Hours](https://tanzu.vmware.com/developer/tv/spring-office-hours/) and will put together a video for my 
YouTube channel soon. If you have questions and would like me to answer them please feel free to reach out. 

## Q&A

Dear Dan,
Thanks for your email, introduce I am Delvin from Indonesia, I am a junior software engineer, I really like all
of your content on YouTube channel and subscribed to it. Honestly I really like the Java programming, but I
realize that I am newbie, many things that I have to learn and some of them I got from your channel.

If you asked me in this email "Is there something you're struggling to learn?" I will answer "Yes", now I am
struggling to create a project which is "Get data from third party api (ex: api 1) and then save into my
database and take the data which is already saved in my database and send it to another third party
api (ex: api 2) I tried to find on Google how to create a project like that but i didn't find it.in my case
simplify like this

( The flow ) :Third party API One ----> My Backend (Spring Boot) --> Db -->My Backend (Spring Boot) -->
Another API Two. If you don't mind, please create a video about that case,
i think it would be very helpful maybe to other peoples too. Thank you so much,if you can make a video
like that, i really appreciate

May God blessing you
Regards,Delvin - Indonesia

## Problem-Solving (The ability to break complex problems into a series of smaller problems)

1. Call Third Party API (API #1)
2. Save Results to DB
3. Create endpoint that will push results from DB -> API #2

## Running the applications

This project uses a Maven Multi Project setup. There are 2 main projects: 

- todos - This is the main service that will consume an API and store the todos in a database
  - Runs on port :8080
- personal-todos - This is a service that can accept 1 or all todos. 
  - Runs on port :8081