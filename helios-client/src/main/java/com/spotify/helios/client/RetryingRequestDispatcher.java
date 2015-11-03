package com.spotify.helios.client;

import com.google.common.util.concurrent.ListenableFuture;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * A {@link RequestDispatcher} implementation that retries. Uses {@link DefaultRequestDispatcher}
 * as a delegate.
 */
class RetryingRequestDispatcher implements RequestDispatcher {

  private final RequestDispatcher delegate;

  RetryingRequestDispatcher(final RequestDispatcher delegate) {
    this.delegate = delegate;
  }

  @Override
  public ListenableFuture<Response> request(final URI uri,
                                            final String method,
                                            final byte[] entityBytes,
                                            final Map<String, List<String>> headers) {
    return delegate.request(uri, method, entityBytes, headers);
  }

  @Override
  public void close() {
    delegate.close();
  }
}
