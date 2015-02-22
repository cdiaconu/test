package test

class PriorityDownUpdateStrategy extends AbstractUpdateStrategy {

	private int newPriority
	private int oldPriority
	private int dirtyProjectId

	public PriorityDownUpdateStrategy(int newPriority, int oldPriority, long dirtyProjectId){
		this.newPriority = newPriority
		this.oldPriority = oldPriority
		this.dirtyProjectId = dirtyProjectId
	}

	@Override
	protected int getFromPriority() {
		return newPriority;
	}

	@Override
	protected int getToPriority() {
		return oldPriority - 1;
	}
	
	@Override
	protected long getDirtyProjectId() {
		return dirtyProjectId;
	}

	@Override
	protected boolean shouldIncrement() {
		return true;
	}
}
