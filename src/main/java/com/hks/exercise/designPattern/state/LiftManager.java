package com.hks.exercise.designPattern.state;

public class LiftManager{

    protected Lift liftState;

    public void setLiftState(Lift liftState) {
        this.liftState = liftState;
        this.liftState.setManager(this);
    }

    public void run() {
        this.liftState.run();
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void stop() {
        this.liftState.stop();
    }
}
