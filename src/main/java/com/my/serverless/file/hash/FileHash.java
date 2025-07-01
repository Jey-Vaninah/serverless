package com.my.serverless.file.hash;

import com.my.serverless.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}
