package com.bladecoder.engineeditor.undo;

import com.bladecoder.engine.model.Scene;
import com.bladecoder.engine.model.World;
import com.bladecoder.engineeditor.Ctx;
import com.bladecoder.engineeditor.model.Project;


public class UndoDeleteScene implements UndoOp {
	private Scene scn;
	
	public UndoDeleteScene(Scene s) {
		scn = s;
	}
	
	@Override
	public void undo() {
		World.getInstance().addScene(scn);
		Ctx.project.setModified(this, Project.NOTIFY_ELEMENT_CREATED, null, scn);
	}
}
