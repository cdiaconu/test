package test

class PriorityUpdateStrategyFactory {

	public static IPriorityUpdateStrategy getStrategy(int newPriority, int oldPriority, EnumPriorityUpdateType updateType, long dirtyProjectId){

		switch (updateType){
			case EnumPriorityUpdateType.INSERT :
				return new InsertPriorityUpdateStrategy(newPriority, dirtyProjectId)
			case EnumPriorityUpdateType.DELETE:
				return new DeletePriorityUpdateStrategy(oldPriority, dirtyProjectId)
			case EnumPriorityUpdateType.UPDATE:
				// 2 -> 5
				if (newPriority > oldPriority){
					return new PriorityUpUpdateStrategy(newPriority, oldPriority, dirtyProjectId)
				}
				// 5 -> 2
				return new PriorityDownUpdateStrategy(newPriority, oldPriority, dirtyProjectId)
		}
	}
}
