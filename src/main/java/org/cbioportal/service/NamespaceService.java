package org.cbioportal.service;

import org.cbioportal.model.Namespace;

import java.util.List;

public interface NamespaceService {

    List<Namespace> fetchNamespaceKeys();
}