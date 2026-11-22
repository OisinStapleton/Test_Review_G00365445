# CICD-1 Coding Test — Review, Improve and Reflect

**Student ID:*G00365445 - Oisin Stapleton*  
**Examination group:*B(OpenFeign)* 
**Original examination pull-request URL (`exam-work`):*https://github.com/OisinStapleton/oisinstapleton_bookingservice_2.git*  
**New review repository URL:*https://github.com/OisinStapleton/Test_Review_G00365445*  

## 1. My original examination self-assessment

Review the code **as submitted in the original examination**. Do not change the original repository, branch or pull request. Check your own Group A or Group B examination paper and award marks only for evidence present in the original submission.

### Task 1 — 9/40
**My mark: 9**  
**Evidence from the original code (files, methods, working or missing requirements):**  
Limited marks. Booking Entity present with incorrect/missing validation. DTO present but incorrect. No room relationship.
### Task 2 — 0/40
**My mark: 0**  
**Evidence from the original code:** 
No Implementation.

### Task 3 — 0/20
**My mark: 0**  
**Evidence from the original code:** 
No Implementation.

**Total self-assessed original examination mark: 9/100**

## 2. Corrections and improvements in my new project

Start from a **fresh copy of the starter template for your own exam group**, in a **new GitHub repository**. You may consult or selectively reuse your own original examination code, but the new project must demonstrate that you understand and can correct it. Do not change your original examination submission.

Describe **two or three important problems** in your original code. For each, explain what was wrong, which class or method you changed in the new project, and why the corrected approach works.

**Problem and correction 1 - Project configuration:**
**Original errors seen in exam and on review**
**Error 1**
<img width="1079" height="726" alt="1000033983" src="https://github.com/user-attachments/assets/89234bdb-b69f-43f8-a701-cb7682c1aa30" />
**Error 2**
This error was why I presumed it was a JDK issue. My thought process in the exam and even afterwards was to make sure my JDK was the same version throughout but cycling through older versions of JDK did not solve the issue.
<img width="1072" height="198" alt="image" src="https://github.com/user-attachments/assets/b071ed36-d8c8-4ec3-8654-021cc74b3ea7" />

**Solution?**
<img width="980" height="236" alt="image" src="https://github.com/user-attachments/assets/ed6b81b1-06b9-4a54-91f6-45e6a8a0c791" />
During my entire exam I was enable to compile any code. When reviewing my test originally I presumed it was an issue due to a JDK version being incompatible but eventually found the issue was due to an issue in "Settings - Maven". All of my projects would automatically configure to a use "Maven Wrapper" setting, changing this setting to "Bundled (Maven 3)" compiled my code straight away. Upon research of this problem it does not say definitively what caused this. The only issue with this is although my code compiles it shows 13 warnings in my pom file. 

**Problem and correction 2 - Booking Entity -> DTO's** 
The main issue was that my Booking entity was not compatible with the DTO that I made. A DTO acts as a middleground between the entity and service layer, my exam code was trying to bring everything in Entity over to the DTO which was not necessary.
In my original Booking class there was implementation but it was accompanied a lot of errors. The inclusion of the @Table annotation was only needed if H2 Database was needed which it was not.
My validation was missing correct syntax in areas with an @Size annotation being left out in favour of an @Min & @Max that would not have worked, @Size would have been able to help me create the range in one annotation.
I also needed two DTO's which I created in my new design. RoomDTO allows BookingService to understand the info returned by Room Service by contacting it through OpenFeign. My CreateBookingRequestDTO recieves the booking details.
 
## 3. API testing and evidence

Use Swagger UI or another HTTP client. For **at least four meaningful checks**, record the request/input, expected result, actual HTTP status/response, and pass/fail. Include unsuccessful cases; a running application alone is not enough.

**Test 1 — successful booking request:**  
- Request / input:  "roomId":1, "organiserName": "Aoife Byrne", "attendeeCount":18
- Expected: Booking works because capacity is 24.
- Actual HTTP status / body:  201 Created
- Pass / fail:  PASS

**Test 2 — invalid input or excessive attendee count:**  
- Request / input:  "roomId":2, "organiserName": "Aoife Byrne", "attendeeCount":18
- Expected:  Fail exceeds capacity
- Actual HTTP status / body:  400 Bad Request
- Pass / fail:  Fail

**Test 3 — missing booking or room:**  
- Request / input: "roomId":999, "organiserName": "Aoife Byrne", "attendeeCount":5
- Expected: Does not exist.
- Actual HTTP status / body: 404 Not Found  
- Pass / fail: Fail

**Test 4 — requirement specific to my group:**  
- Request / input:  "roomId":1, "organiserName": "", "attendeeCount":10
- Expected:  Rejected organiserName blank.
- Actual HTTP status / body: 400 Bad Request 
- Pass / fail:  Fail

**Group B:** Run the **provided** Room Service separately on port 8082 and the **new** Booking Service on port 8081. Demonstrate that booking creation obtains room details through OpenFeign and that booking retrieval uses the local Booking database. Do not modify the Room Service.

## 4. Reflection

**What did I understand during the examination but struggle to implement?**
In my exam I understood the layers in my project better than I implemented in the exam. Due to spending a lot of time trying to just compile my code I rushed at the end putting down what I could so I would get some sort of mark. 
Controller -> Receives Http requests, Converts JSON to Java Object, Calls Service layer
ServiceLayer -> Business logic, Receives request from Controller, Uses Repo layer to save a booking
RepoLayer -> Perfroms JPA methods (findall(), findbyId())
Entity -> Acts as a booking stored in the database

**Which Spring Boot, JPA, validation, JPQL or OpenFeign concept became clearer after correcting my code? Give a specific example.**
OpenFeign implementation has now become clearer to me after re-doing the exam. OpenFeign allowed me to communicate with the Service layer without having to write HTTP codes myself.
@FeignClient tells Spring it is a FeignClient and tells it what port its running on through the url. @GetMapping("api/rooms/{id} tells OpenFeign which endpoint to contact to perfrom the GET request.
OpenFeign also converts JSON objects into Java Objects making it a good midpoint between both services (room and booking).

**What will I do differently in my next coding test or API development task?**
My notes were not helpful, I focused on recording snippets of code that I thought I would forget rather than taking notes that would have aided me in the undertsanding of the project as a whole.
I would think more about the question asked and focus on that rather than trying to remember what I was doing in labs and get it down as it was not compatible for the most part.

## Review lab assessment — 20 marks

- Honest original self-assessment with code evidence: **4 marks**
- Explanation of mistakes and Spring Boot concepts: **6 marks**
- Corrections in the new application: **4 marks**
- API testing and demonstration of understanding: **4 marks**
- Reflection and future improvement: **2 marks**

**Total: 20 marks.** Simply submitting a working solution does not demonstrate the learning required by this review.

## Proposed mark recovery — only if confirmed for CICD-1

If the same approach as OOP is adopted, the review could recover **up to 30% of marks lost** in the original examination, scaled by the review-lab mark.

**Marks recovered = (100 − official original exam mark) × 0.30 × (review lab mark ÷ 20)**

Example: exam **40/100** and review **16/20** → **14.4 recovered marks**, revised exam **54.4/100**. This is **not an approved CICD-1 policy unless confirmed by the lecturer**. The original official exam mark—not your self-awarded grade—is used in the calculation.

## Submission

Commit and push the **new review repository** with the completed README, corrected Spring Boot code and API-test evidence. Submit its GitHub URL on Moodle. **Do not push any changes to the original examination repository or `exam-work` pull request.**
