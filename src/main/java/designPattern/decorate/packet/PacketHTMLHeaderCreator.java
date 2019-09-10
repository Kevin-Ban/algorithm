package designPattern.decorate.packet;

public class PacketHTMLHeaderCreator extends PacketDecorator {

    public PacketHTMLHeaderCreator(IpacketCreator ipacketCreator) {
        super(ipacketCreator);
    }

    @Override
    public String handleContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");
        sb.append(ipacketCreator.handleContent());
        sb.append("</body></html>");
        return sb.toString();
    }
}
