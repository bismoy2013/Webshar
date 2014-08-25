Webshar Inc
===========

Problem: A simple Messaging System
 
Overall Idea
A messaging system has a central message server, and many clients connected to it. Each client sends a message to the central server, and its server's responsibility to relay that message to some of the clients. 
 
Networking/sockets are out of scope for this problem. Its a single process multi-threaded system.
 
Each of the server/client components is simply a thread. The way they communicate amongst themselves is via a limited buffer (say, an array) that exists between any two components. Suppose a client A wants to communicate to server X, then it will put the "message" in the buffer that is shared between A & X. Similarly if server X wants to communicate to client B, then it will put the "message" in the buffer that is shared between X & B. Note that since, all of X, A, B components are running in their own thread, it must be ensured that there's no problem that might arise because of multithreading.
 
Constraints
 All the "components" are running in their own threads.
Assume that the "message" is simply an integer.
The buffer between any two components is limited.
Server component is created during program startup. Clients are created according to user input. Any number of clients can connect to the server. (See I/O below)
The message that the client to the server will send will also be a user input. (See I/O below)
Upon receiving a message(an integer) from one of the clients, the server then comes up with a subset of clients that it will forward the message to. (See server forwarding section below)
Server Forwarding
The server would maintain a list of all the connected clients. During creation of a client, the user will specify client ID -- an integer. Server will maintain "ClientID" of all connected clients. This ClientID is specified by the user during runtime.
 
When a client sends a message (an integer), the server creates a subset of the clients to which the message will be forwarded to. This subset creation is created as:
 
All the clients whose "ClientID" are divisible by the integer-message just obtained.
 
Let's take the example: Suppose the user creates 5 clients, with the client IDs as [3,7,8,12,17]. Now let's say Client with ID=7 sends a message: 48. The server receives the message "48". The number 48 is divisible by the numbers 3,8,12 but not by number 7 & 17. The server will now forward this message "48", to client IDs: 3,8,12. In simpler words, client with ID=7 sends a message 48, and it received by the client with ID= 3, 8, 12.
 
Sample Input/Output
(some extra stdout lines have written to help get the overall idea)
 
[Server] Server Started.
[Server] Waiting for clients to connect.
[UserInput] Choose from options below:
[UserInput] 1. Create a new client
[UserInput] 2. Send a message on behalf of some client
[UserInput] Enter Choice: 1
[UserInput] Creating a new client. Enter ClientID: 3
[Server] Accepted a new Client with ID=3
[UserInput] Choose from options below:
[UserInput] 1. Create a new client
[UserInput] 2. Send a message on behalf of some client
[UserInput] Enter Choice: 1
[UserInput] Creating a new client. Enter ClientID: 7
[Server] Accepted a new Client with ID=7
[UserInput] Choose from options below:
[UserInput] 1. Create a new client
[UserInput] 2. Send a message on behalf of some client
[UserInput] Enter Choice: 1
[UserInput] Creating a new client. Enter ClientID: 8
[Server] Accepted a new Client with ID=8
[UserInput] Choose from options below:
[UserInput] 1. Create a new client
[UserInput] 2. Send a message on behalf of some client
[UserInput] Enter Choice: 1
[UserInput] Creating a new client. Enter ClientID: 12
[Server] Accepted a new Client with ID=12
[UserInput] Choose from options below:
[UserInput] 1. Create a new client
[UserInput] 2. Send a message on behalf of some client
[UserInput] Enter Choice: 1
[UserInput] Creating a new client. Enter ClientID: 17
[Server] Accepted a new Client with ID=17
[UserInput] Choose from options below:
[UserInput] 1. Create a new client
[UserInput] 2. Send a message on behalf of some client
[UserInput] Enter Choice: 2
[UserInput] Through which client to send the message. Enter ID: 7
[UserInput] Enter Integer message: 48
[Server] Got a message from ClientID=7, message=48.
[Server] Forwarding message=48 to ClientIDs=[3, 8, 12]
[Client3] Got a message from server: Message=48
[Client8] Got a message from server: Message=48
[Client12] Got a message from server: Message=48
 

Please provide a full project that:
Has a very clean class design. Please design with future extensibility in mind. Ask yourself the following questions:
Can I very easily replace the core logic that is used for forwarding -- in this case divisibility is the core logic ?
Can I very easily change the size of the buffer between two component without having to recompile the project ?
Can I change the type of the message to be much more than a simple Integer ?
Opens with any popular IDE such as Eclipse.
contain unit tests. They are preferred, but not mandatory.
