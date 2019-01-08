package com.trach.bank.services.interfaces;

import com.trach.bank.dto.TransferDTO;
import com.trach.bank.exceptions.transfer.TransferException;

public interface TransferService  {
    void transfer(TransferDTO t) throws  TransferException;
}
