package com.jkantrell.nbt.io;

import com.jkantrell.io.StringDeserializer;
import com.jkantrell.nbt.tag.Tag;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.stream.Collectors;

public class SNBTDeserializer implements StringDeserializer<Tag<?>> {

	@Override
	public Tag<?> fromReader(Reader reader) throws IOException {
		return fromReader(reader, Tag.DEFAULT_MAX_DEPTH);
	}

	public Tag<?> fromReader(Reader reader, int maxDepth) throws IOException {
		BufferedReader bufferedReader;
		if (reader instanceof BufferedReader) {
			bufferedReader = (BufferedReader) reader;
		} else {
			bufferedReader = new BufferedReader(reader);
		}
		return new SNBTParser(bufferedReader.lines().collect(Collectors.joining())).parse(maxDepth);
	}
}
