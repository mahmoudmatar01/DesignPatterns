public class Director extends Handler{
    @Override
    public void handleRequest(Request request) {
        if(request.requestType()==RequestType.CONFERENCE){
            System.out.println("Director can approve conference");
        }else{
            successor.handleRequest(request);
        }
    }
}
