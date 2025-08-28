# Socket Programming in Java

This project is a **basic client-server application** built in Java using **socket programming**.  
It demonstrates how two programs (a server and a client) can communicate over TCP sockets.  

The repo includes:
- A **Server** that listens for client connections on a given port.
- A **Client** that connects to the server and sends messages.
- A simple **message exchange loop** between client and server.

---

## 🚀 Features
- Establish a TCP connection between server and client.
- Server accepts incoming connections and reads client input.
- Client sends messages to the server.
- Console-based communication (text messages).
- Demonstrates blocking I/O with `ServerSocket` and `Socket`.

---

## 📂 Project Structure

Socket_programming_Java/
├── src/
│ └── Networking/
│ ├── Server.java # Starts a server and listens for clients
│ └── Client.java # Connects to the server and sends messages
└── README.md


---

## 🛠️ How to Run

1. **Compile the code** (from project root):
   ```
   javac src/Networking/*.java
   ```

2. Run the server (choose a port, e.g., 12345):
```
java -cp src Networking.Server
```

3. Run the client (in a new terminal, same port):
```
java -cp src Networking.Client
```

4. Exchange messages

Type into the client console, server will display it.

(You can modify to send responses back as well).

## 📖 Concepts Shown

Java Networking APIs (ServerSocket, Socket, BufferedReader, InputStreamReader, PrintWriter).
Blocking I/O and connection handling.
Basics of client-server architecture.

## 🔮 Possible Improvements

- Support multiple clients (thread pool or NIO selectors).
- Add a protocol (commands like LOGIN, MSG, QUIT).
- Use heartbeats to detect disconnected clients.
- Add logging (SLF4J + Logback) instead of System.out.println.

