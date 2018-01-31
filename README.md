# PseExamHelper
This repository is intended as a helper for learning Machine Learning for the PSE Exam.

**How to correctly populate it?**
1. Take a screenshot of the quiz question.
2. Name and place that screenshot in the appropriate folder. s1 for first section(chapter1), s2 for second and so on. The questions need to be named q1.png, q2.png,...
3. Update the xml as follows:
```xml
<section title="Example Section">
        <question type="single" path="/img/s1/q2.PNG"> 
            <!-- Type of question: single/multiple/input and path to the image -->
            <answers>
                <!-- For single/multi, use 4 answers (regardless of how many there are) 
                and mark them with type="right" for the right ones and type="wrong" for the wrong ones -->
                <answer type="right"/>
                <answer type="wrong"/>
                <answer type="wrong"/>
                <answer type="wrong"/>
            </answers>
        </question>
        <question type="multi" path="/img/s1/q2.png">
            <answers>
                <answer type="right"/>
                <answer type="right"/>
                <answer type="wrong"/>
                <answer type="wrong"/>
            </answers>
        </question>
        <question type="input" path="/img/s1/q3.png">
            <answers>
                <!-- Only one answer with the value equal to 
                the expected string to be typed by the user -->
                <answer type="right" value="4"/>
            </answers>
        </question>
    </section>
</sections>
```
4. Enjoy and start learning!
