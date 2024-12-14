package euromil;

// Import necessary dependencies
import io.grpc.stub.StreamObserver; // For handling streaming responses
import io.github.lognet.grpc.GrpcService; // For marking this class as a gRPC service
import euromil.RegisterRequest; // Generated gRPC message class for request
import euromil.RegisterReply; // Generated gRPC message class for reply
import euromil.EuromilGrpc; // Base class for defining service methods

/**
 * This class implements the Euromil service using gRPC.
 * It provides a concrete implementation of the service defined in the gRPC proto file.
 */
@GrpcService
public class EuromilServiceImpl extends EuromilGrpc.EuromilImplBase {

  /**
   * Handles the registration of EuroMillions entries.
   *
   * @param request           The incoming request containing key and check ID.
   * @param responseObserver  Used to send responses back to the client.
   */
  @Override
  public void registerEuroMil(RegisterRequest request, StreamObserver<RegisterReply> responseObserver) {

    // Extract relevant information from the request
    String key = request.getKey();
    String checkid = request.getCheckid();

    // Prepare a response message confirming the registration
    String message = "Successfully registered EuroMillions with check ID: " + checkid;

    // Build the reply message to send back to the client
    RegisterReply reply = RegisterReply.newBuilder()
      .setMessage(message)
      .build();

    // Send the reply to the client
    responseObserver.onNext(reply);

    // Indicate that the server has finished sending responses
    responseObserver.onCompleted();
  }
}
