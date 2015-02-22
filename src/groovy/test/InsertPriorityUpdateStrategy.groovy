package test

class InsertPriorityUpdateStrategy extends AbstractUpdateStrategy {

	private int newPriority
	private int dirtyProjectId

	public InsertPriorityUpdateStrategy(int newPriority, long dirtyProjectId){
		this.newPriority = newPriority
		this.dirtyProjectId = dirtyProjectId
	}

	@Override
	protected int getFromPriority() {
		return newPriority;
	}

	@Override
	protected int getToPriority() {
		return Project.count;
	}
	
	@Override
	protected long getDirtyProjectId() {
		return dirtyProjectId
	}

	@Override
	protected boolean shouldIncrement() {
		return true;
	}
}
