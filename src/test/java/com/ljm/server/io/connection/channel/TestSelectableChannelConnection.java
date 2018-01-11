package com.ljm.server.io.connection.channel;

import org.junit.Test;

import java.nio.channels.SelectionKey;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestSelectableChannelConnection {
    @Test
    public void testRead() {
        SelectionKey selectionKey = mock(SelectionKey.class);
        when(selectionKey.isReadable()).thenReturn(true);

    }
}
