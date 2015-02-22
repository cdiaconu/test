package test

class PriorityUpUpdateStrategy extends AbstractUpdateStrategy {

	private int newPriority
	private int oldPriority
	private long dirtyProjectId

	public PriorityUpUpdateStrategy(int newPriority, int oldPriority, long dirtyProjectId){
		this.newPriority = newPriority
		this.oldPriority = oldPriority
		this.dirtyProjectId = dirtyProjectId
	}

	@Override
	protected int getFromPriority() {
		return oldPriority + 1
	}

	@Override
	protected int getToPriority() {
		return newPriority
	}
	
	@Override
	protected long getDirtyProjectId() {
		return dirtyProjectId
	}

	@Override
	protected boolean shouldIncrement() {
		return false
	}

}
