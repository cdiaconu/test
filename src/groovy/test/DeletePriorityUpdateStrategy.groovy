package test

class DeletePriorityUpdateStrategy extends AbstractUpdateStrategy {

	private int oldPriority
	private long dirtyProjectId

	public DeletePriorityUpdateStrategy(int oldPriority, long dirtyProjectId){
		this.oldPriority = oldPriority
		this.dirtyProjectId = dirtyProjectId
	}

	@Override
	protected int getFromPriority() {
		return oldPriority + 1
	}

	@Override
	protected int getToPriority() {
		return Project.count
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
