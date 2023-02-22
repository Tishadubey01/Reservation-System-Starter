package ui;

import ui.command.Command;

public class Button {
	private float x; 
	private float y;
    private float height;
    private float width;

    private Command command;

    Button(float x, float y, float height, float width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public void renderButton() {
        assert this.x != 0;
        assert this.y != 0;
        assert this.height != 0;
        assert this.width != 0;
    }

    public void clickButton() {
        command.exec();
    }
}
