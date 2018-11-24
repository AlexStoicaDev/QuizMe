package quizme.demo.mappers;

import lombok.experimental.UtilityClass;
import quizme.demo.dtos.NonScoredQuestionDtoIn;
import quizme.demo.dtos.ScoredQuestionDtoIn;
import quizme.demo.entities.questions.NonScoredQuestion;
import quizme.demo.entities.questions.ScoredQuestion;

@UtilityClass
public class QuestionMapper {

    public ScoredQuestion toInBound(ScoredQuestionDtoIn scoredQuestionDtoIn) {

        ScoredQuestion scoredQuestion = new ScoredQuestion();
        scoredQuestion.setAnswers(scoredQuestionDtoIn.getAnswers());
        scoredQuestion.setScore(scoredQuestionDtoIn.getScore());
        scoredQuestion.setQuestionCategory(scoredQuestionDtoIn.getQuestionCategory());
        scoredQuestion.setQuestionDifficultyLevel(scoredQuestionDtoIn.getQuestionDifficultyLevel());
        scoredQuestion.setTimeConstraint(scoredQuestionDtoIn.getTimeConstraint());

        return scoredQuestion;
    }

    public NonScoredQuestion toInBound(NonScoredQuestionDtoIn nonScoredQuestionDtoIn) {

        NonScoredQuestion nonScoredQuestion = new NonScoredQuestion();
       nonScoredQuestion.setAnswer(nonScoredQuestionDtoIn.getAnswer());
       nonScoredQuestion.setQuestionCategory(nonScoredQuestion.getQuestionCategory());
       nonScoredQuestion.setQuestionDifficultyLevel(nonScoredQuestion.getQuestionDifficultyLevel());
       nonScoredQuestion.setTimeConstraint(nonScoredQuestion.getTimeConstraint());

        return nonScoredQuestion;

    }
}
