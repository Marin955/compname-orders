package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.account.*;
import com.compname.orders.api.message.response.account.*;
import com.compname.orders.api.model.account.Account;
import com.compname.orders.api.service.AccountService;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.core.validation.AccountRequestValidator;
import com.compname.orders.utility.OrdersServiceException;
import com.compname.orders.utility.ResponseCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class AccountPeer implements AccountService {

    private final AccountRequestValidator validator;
    private final InternalOrderService service;

    @Override
    public CreateAccountResponse create(CreateAccountRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new CreateAccountResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        Account account = service.create(request).toApi();
        return new CreateAccountResponse(request, ResponseCode.OK, account);
    }

    @Override
    public GetAccountResponse get(GetAccountRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new GetAccountResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        return new GetAccountResponse(request, ResponseCode.OK, null);
    }

    @Override
    public DeleteAccountResponse delete(DeleteAccountRequest request)
    {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new DeleteAccountResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        return new DeleteAccountResponse(request, ResponseCode.OK, null);
    }

    @Override
    public SearchAccountResponse search(SearchAccountRequest request)
    {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new SearchAccountResponse(request, ResponseCode.REQUEST_INVALID, null,0,0);
        }
        return new SearchAccountResponse(request, ResponseCode.OK, null,0,0);
    }

    @Override
    public UpdateAccountResponse update(UpdateAccountRequest request)
    {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new UpdateAccountResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        return new UpdateAccountResponse(request, ResponseCode.OK, null);
    }
}
