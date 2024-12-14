package euromil;

import io.grpc.stub.StreamObserver;
import io.github.lognet.grpc.GrpcService;
import euromil.RegisterRequest;
import euromil.RegisterReply;
import euromil.EuromilGrpc;

@GrpcService
public class EuromilServiceImpl extends EuromilGrpc.EuromilImplBase {

  @Override
  public void registerEuroMil(RegisterRequest request, StreamObserver<RegisterReply> responseObserver) {
    String key = request.getKey();
    String checkid = request.getCheckid();

    // Handle the registration logic
    String message = "Successfully registered EuroMillions with check ID: " + checkid;

    // Create a response
    RegisterReply reply = RegisterReply.newBuilder()
      .setMessage(message)
      .build();

    // Send the response
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }
}
