package main

import (
	"fmt"
	"net/http"

	"golang.org/x/net/http2"
)

func main() {
	server := http.Server{
		Addr:    ":8080",
		Handler: http.HandlerFunc(hello),
	}
	http2.ConfigureServer(&server, &http2.Server{})
	server.ListenAndServe()
}

func hello(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "hello")
}
