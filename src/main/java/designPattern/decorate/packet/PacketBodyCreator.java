package designPattern.decorate.packet;

public class PacketBodyCreator implements IpacketCreator {
    @Override
    public String handleContent() {
        return "content of packet";
    }
}
