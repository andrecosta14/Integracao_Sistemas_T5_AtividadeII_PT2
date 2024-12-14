package euromil.register;

// Importing necessary packages and classes for gRPC and communication
import euromil.EuromilGrpc;
import euromil.RegisterReply;
import euromil.RegisterRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class EuromilClient {

  public static void main(String[] args) {

    // Creating a channel for communication with the gRPC server
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
      .usePlaintext() // Ensures communication is not encrypted
      .build();

    // Creating a blocking stub to perform synchronous gRPC calls
    EuromilGrpc.EuromilBlockingStub stub = EuromilGrpc.newBlockingStub(channel);

    // Creating a request object with the required parameters
    RegisterRequest request = RegisterRequest.newBuilder()
      .setKey("12345") // Setting the unique key for the request
      .setCheckid("9876543210123456") // Setting a check ID (possibly a unique identifier)
      .build();

    // Sending the request to the server and receiving the response
    RegisterReply response = stub.registerEuroMil(request);

    // Printing the server's response to the console
    System.out.println("Response: " + response.getMessage());

    // Closing the communication channel after completing the operations
    channel.shutdown();
  }
}
