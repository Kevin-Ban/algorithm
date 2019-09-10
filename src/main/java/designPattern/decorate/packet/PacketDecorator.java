package designPattern.decorate.packet;

public abstract class PacketDecorator implements IpacketCreator {

    IpacketCreator ipacketCreator;

    public PacketDecorator(IpacketCreator ipacketCreator){
        this.ipacketCreator = ipacketCreator;
    }
}
