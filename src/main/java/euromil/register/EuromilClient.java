package euromil.register;

import euromil.EuromilGrpc;
import euromil.RegisterReply;
import euromil.RegisterRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class EuromilClient {

  public static void main(String[] args) {
    // Create the gRPC channel
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
      .usePlaintext()
      .build();

    // Create a stub for the Euromil service
    EuromilGrpc.EuromilBlockingStub stub = EuromilGrpc.newBlockingStub(channel);

    // Prepare the request
    RegisterRequest request = RegisterRequest.newBuilder()
      .setKey("12345")
      .setCheckid("9876543210123456")
      .build();

    // Make the gRPC call
    RegisterReply response = stub.registerEuroMil(request);

    // Print the response
    System.out.println("Response: " + response.getMessage());

    // Shutdown the channel
    channel.shutdown();
  }
}
