package ro.andrei.quiz.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ro.andrei.quiz.model.Answer;
import ro.andrei.quiz.model.Question;
import ro.andrei.quiz.model.Section;

public class QuestionParserService {

    static final String XML_PATH = "src/main/resources/questions.xml";

    static final String SECTION = "section";
    static final String QUESTION = "question";
    static final String ANSWERS = "answers";
    static final String ANSWER = "answer";

    static final String ATTR_TITLE = "title";
    static final String ATTR_TYPE = "type";
    static final String ATTR_PATH = "path";
    static final String ATTR_VALUE = "value";

    public List<Section> parseFile() {
        List<Section> sections = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(XML_PATH);
            NodeList nodeList = document.getElementsByTagName(SECTION);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Section section = parseSection(node);
                sections.add(section);
            }
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            Logger.getLogger(QuestionParserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Section section : sections) {
            System.out.println(section.getTitle());
            for (Question q : section.getQuestionList()) {
                System.out.println("...Q: " + q.getPath() + " " + q.getType());
                for (Answer a : q.getAnswers()) {
                    System.out.println("......A: " + a.getType() + " " + a.getValue());
                }
            }
        }

        return sections;
    }

    private Section parseSection(Node node) {
        Section section = null;
        if (node instanceof Element) {
            section = new Section();
            section.setTitle(((Element) node).getAttribute(ATTR_TITLE));

            List<Question> questionList = new ArrayList<>();

            NodeList questionNodes = ((Element) node).getElementsByTagName(QUESTION);
            for (int i = 0; i < questionNodes.getLength(); i++) {
                Node qNode = questionNodes.item(i);

                if (qNode instanceof Element) {
                    Question question = new Question();
                    question.setType(((Element) qNode).getAttribute(ATTR_TYPE));
                    question.setPath(((Element) qNode).getAttribute(ATTR_PATH));

                    List<Answer> answers = new ArrayList<>();
                    NodeList answerNodes = ((Element) qNode).getElementsByTagName(ANSWER);

                    for (int j = 0; j < answerNodes.getLength(); j++) {
                        Node aNode = answerNodes.item(j);

                        if (aNode instanceof Element) {
                            Answer answer = new Answer();
                            answer.setType(((Element) aNode).getAttribute(ATTR_TYPE));
                            answer.setValue(((Element) aNode).getAttribute(ATTR_VALUE));
                            answers.add(answer);
                        }
                    }
                    question.setAnswers(answers);
                    questionList.add(question);
                }
            }
            section.setQuestionList(questionList);
        }
        return section;
    }
}
