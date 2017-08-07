package service;

import aspects.LoggingAspect;
import model.Circle;

public class ShapeServiceProxy extends ShapeService {

    @Override
    public Circle getCircle() {
        new LoggingAspect().loggingAdvice();
        return super.getCircle();
    }
}
