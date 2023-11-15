package com.craftinginterpreters.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

public class Lox {

  static boolean hadError = false;

  public static void main(String[] args) throws IOException {
    if(args.length > 1){
      System.out.println("Usage: jlox [script]"); 
      System.exit(64);
    } else if (args.length == 1){
      runFile(args[0]);
    } else {
      runPrompt();
    }
  }

  private static void runFile(String path) throws IOException {
    byte[] bytes = Files.readAllBytes(Paths.get(path));
    run(new String(bytes, Charset.defaultCharset()));

    // Exit if error (with error code)
    if(hadError) System.exit(65);
  }

  // Interactive running of prompt
  private static void runPrompt() throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);

    for (;;) {
      System.out.println("> ");
      String line = reader.readLine();
      if (line == null) break;
      run(line);

      hadError = false; // Resetting this error in interactive loop
      // One prompt can have some error and fail to run but the program
      // cannot fail completely. The next prompt should run normally
      // for which the hadError flag has to be cleared.
      
    }
  }

  private static void run(String source){

    for (Token token: tokens){
      System.out.println(token);
    }
  }

  // Error handling - should be able to handle different types of errors
  static void error(int line, String message){
    report(line, "", message);
  }
  // Design the report message for the error
  private static void report(int line, String where, String message){
    System.err.println("[line" + line + "] Error" + where + ": " + message);
    hadError = true;
  }
}
