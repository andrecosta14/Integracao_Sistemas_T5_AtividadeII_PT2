package euromil.register;

import euromil.EuromilGrpc;
import euromil.RegisterReply;
import euromil.RegisterRequest;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

// Annotates the class as a Spring Service to enable dependency injection
@Service
public class EuromilService extends EuromilGrpc.EuromilImplBase {

  // Overrides the gRPC service method for registering a Euromil bet
  @Override
  public void registerEuroMil(RegisterRequest request, StreamObserver<RegisterReply> responseObserver) {

    // Extracts the key and checkid fields from the gRPC request
    String key = request.getKey();
    String checkid = request.getCheckid();

    // Constructs a response message acknowledging the registered bet
    String responseMessage = "Bet successfully registered with key: " + key + " and checkid: " + checkid;

    // Creates a gRPC reply object with the response message
    RegisterReply reply = RegisterReply.newBuilder()
      .setMessage(responseMessage)
      .build();

    // Sends the reply back to the client
    responseObserver.onNext(reply);

    // Indicates the completion of the gRPC call
    responseObserver.onCompleted();
  }
}
