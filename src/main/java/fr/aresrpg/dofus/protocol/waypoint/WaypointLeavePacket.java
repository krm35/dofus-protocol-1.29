package fr.aresrpg.dofus.protocol.waypoint;

import fr.aresrpg.dofus.protocol.DofusStream;
import fr.aresrpg.dofus.protocol.Packet;
import fr.aresrpg.dofus.protocol.PacketHandler;

public class WaypointLeavePacket implements Packet{
	@Override
	public void read(DofusStream stream) {}

	@Override
	public void write(DofusStream stream) {}

	@Override
	public void handle(PacketHandler handler) {
		handler.handle(this);
	}

	@Override
	public String toString() {
		return "WaypointLeavePacket()[" + getId() + ']';
	}
}