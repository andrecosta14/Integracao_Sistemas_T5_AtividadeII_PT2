package euromil.register;

import euromil.EuromilGrpc;
import euromil.RegisterReply;
import euromil.RegisterRequest;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class EuromilService extends EuromilGrpc.EuromilImplBase {

  @Override
  public void registerEuroMil(RegisterRequest request, StreamObserver<RegisterReply> responseObserver) {
    String key = request.getKey();
    String checkid = request.getCheckid();

    // Simulating some business logic to register the EuroMillions bet
    String responseMessage = "Bet successfully registered with key: " + key + " and checkid: " + checkid;

    // Create the response
    RegisterReply reply = RegisterReply.newBuilder()
      .setMessage(responseMessage)
      .build();

    // Send the response back to the client
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }
}
